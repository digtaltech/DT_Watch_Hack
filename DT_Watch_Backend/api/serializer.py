from rest_framework import serializers
from .models import Worker, Health, Pulse, WatchDog, Alert
from django.contrib.auth.models import User
from datetime import date


class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = ['id', 'username']


class PulseSerializer(serializers.ModelSerializer):
    class Meta:
        model = Pulse
        fields = ['id', 'worker', 'pulseMin', 'pulseMax', 'date']


class HealthSerializer(serializers.ModelSerializer):
    class Meta:
        model = Health
        fields = ['id', 'pulseLast', 'pulseMin', 'pulseMax', 'state']


class WatchDogSerializer(serializers.ModelSerializer):
    class Meta:
        model = WatchDog
        fields = ['id','checkIn', 'checkOut', 'date']



class WorkerSerializer(serializers.HyperlinkedModelSerializer):
    health = HealthSerializer(many=True)
    # url = serializers.HyperlinkedIdentityField(view_name='api:worker-detail', source='worker')
    # queryset = WatchDog.objects.filter(date=date.today())
    # watchdog = WatchDogSerializer(many=True, queryset=WatchDog.objects.filter(date=date.today()))
    watchdogToday = serializers.SerializerMethodField('get_watchdog_today')

    def get_watchdog_today(self, worker):
        # qs = WatchDog.objects.filter(worker=2)
        qs = WatchDog.objects.filter(date=date.today(), worker=worker)
        serializer = WatchDogSerializer(instance=qs, many=True)
        return serializer.data

    watchdogWeek = serializers.SerializerMethodField('get_watchdog_week')

    def get_watchdog_week(self, worker):
        # qs = WatchDog.objects.filter(worker=2)
        qs = WatchDog.objects.filter(worker=worker).order_by("-id")[0:7]
        serializer = WatchDogSerializer(instance=qs, many=True)
        return serializer.data

    pulse = serializers.SerializerMethodField('get_pulse_week')

    def get_pulse_week(self, worker):
        # qs = WatchDog.objects.filter(worker=2)
        qs = Pulse.objects.filter(worker=worker).order_by("-id")[0:7]
        serializer = PulseSerializer(instance=qs, many=True)
        return serializer.data

    username = serializers.ReadOnlyField(source='username.username')
    company = serializers.ReadOnlyField(source='company.name')

    class Meta:
        model = Worker
        fields = ['url', 'id', 'username', 'firstName', 'lastName',
                  'status', 'specialty', 'location', 'company', 'health', 'watchdogToday', 'watchdogWeek', 'pulse']

    def update(self, instance, validated_data):
        instance.firstName = validated_data.get(
            'firstName', instance.firstName)
        instance.save()
        items = validated_data.get('health')

        for item in items:
            item_id = item.get('id', None)
            if item_id:
                inv_item = Health.objects.get(id=item_id, invoice=instance)
                inv_item.pulseLast = item.get('pulseLast', inv_item.pulseLast)
                inv_item.save()
            else:
                Health.objects.update(worker=instance, **item)

            return instance

class AlertSerializer(serializers.HyperlinkedModelSerializer):
    urlWorker = serializers.HyperlinkedIdentityField(view_name='worker-detail')
    firstName = serializers.ReadOnlyField(source='worker.firstName')
    lastName = serializers.ReadOnlyField(source='worker.lastName')
    class Meta:
        model = Alert
        fields = ['id', 'urlWorker', 'firstName', 'lastName', 'status']

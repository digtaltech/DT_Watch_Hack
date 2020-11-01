from django.db import models

# Create your models here.
from django.conf import settings
from django.db.models.signals import post_save
from django.dispatch import receiver
from rest_framework.authtoken.models import Token


class Worker(models.Model):  # Работники
    username = models.ForeignKey(
        'auth.User', related_name='workers', on_delete=models.CASCADE)
    photo = models.TextField(max_length=200)  # Фотография сотрудника
    firstName = models.TextField(max_length=200)  # Имя
    lastName = models.TextField(max_length=200)  # Фамилия
    status = models.BooleanField()  # Статус (Работает или нет)
    specialty = models.TextField(max_length=200)  # Специалитет сотрудника
    location = models.TextField(max_length=200)  # Текущая локация работы
    # Компания у которой работает сотрудник
    company = models.ForeignKey(
        'api.Company', related_name='workercompany', on_delete=models.CASCADE)


class WatchDog(models.Model):  # Статистика проохождения Check IN/OUT
    worker = models.ForeignKey(
        'api.Worker', related_name='watchdog', on_delete=models.CASCADE)
    checkIn = models.TimeField()  # Время выхода на смену
    checkOut = models.TimeField()  # Время выхода на смену
    date = models.DateField()  # Дата


class Health(models.Model):  # Состояние здоровья
    worker = models.ForeignKey(
        'api.Worker', related_name='health', on_delete=models.CASCADE)
    # Показание последнего измерения пульса
    pulseLast = models.IntegerField()
    pulseMin = models.IntegerField()  # Минимальный пульс
    pulseMax = models.IntegerField()  # Максимальный пульс
    state = models.IntegerField()  # Состояние здоровья


class Pulse(models.Model):  # Показания пульса по дням
    worker = models.ForeignKey(
        'api.Worker', related_name='pulse', on_delete=models.CASCADE)
    pulseMin = models.IntegerField()  # Минимальный пульс
    pulseMax = models.IntegerField()  # Максимальный пульс
    date = models.DateField()  # Дата


class Company(models.Model):  # Компания
    name = models.TextField(max_length=200)  # Название компании
    owner = models.TextField(max_length=200)  # Владелец компании

class Alert(models.Model):  # Уведомления
    worker = models.ForeignKey(
        'api.Worker', related_name='alert', on_delete=models.CASCADE)
    status = models.IntegerField()  # Название компании


@receiver(post_save, sender=settings.AUTH_USER_MODEL)
def create_auth_token(sender, instance=None, created=False, **kwargs):
    if created:
        Token.objects.create(user=instance)

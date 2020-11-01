from django.shortcuts import render
from rest_framework import viewsets, generics
from .models import Worker, Pulse, Alert
from django.contrib.auth.models import User
from .serializer import UserSerializer, WorkerSerializer, PulseSerializer, AlertSerializer
from rest_framework import permissions
from .permissions import IsOwnerOrReadOnly
from rest_framework.decorators import api_view
from rest_framework import generics

# Create your views here.
# @api_view(['GET', 'POST'])


class UserViewSet(viewsets.ModelViewSet):
    serializer_class = UserSerializer

    def get_queryset(self):
        queryset = User.objects.all()
        return queryset
    permission_classes = [permissions.IsAuthenticatedOrReadOnly,
                          IsOwnerOrReadOnly]


class WorkerViewSet(viewsets.ModelViewSet):

    serializer_class = WorkerSerializer

    def get_queryset(self):

        queryset = Worker.objects.all()
        return queryset

    permission_classes = [permissions.IsAuthenticatedOrReadOnly,
                          IsOwnerOrReadOnly]


class PulseViewSet(viewsets.ModelViewSet):

    serializer_class = PulseSerializer

    def get_queryset(self):

        queryset = Pulse.objects.all()
        return queryset

    permission_classes = [permissions.IsAuthenticatedOrReadOnly,
                          IsOwnerOrReadOnly]

class AlertViewSet(viewsets.ModelViewSet):

    serializer_class = AlertSerializer

    def get_queryset(self):

        queryset = Alert.objects.all()
        return queryset

    permission_classes = [permissions.IsAuthenticatedOrReadOnly,
                          IsOwnerOrReadOnly]

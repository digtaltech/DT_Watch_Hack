from django.contrib import admin
from .models import Worker, Company, Health, Pulse, WatchDog, Alert
# Register your models here.

admin.site.register(Worker)
admin.site.register(Company)
admin.site.register(Health)
admin.site.register(Pulse)
admin.site.register(WatchDog)
admin.site.register(Alert)

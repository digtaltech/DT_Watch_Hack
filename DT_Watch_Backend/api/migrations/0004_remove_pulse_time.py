# Generated by Django 3.1.2 on 2020-10-29 19:56

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('api', '0003_pulse_time'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='pulse',
            name='time',
        ),
    ]

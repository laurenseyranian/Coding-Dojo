# -*- coding: utf-8 -*-
# Generated by Django 1.10 on 2019-10-14 22:58
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('tv_shows_app', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='show',
            name='release_date',
            field=models.DateField(),
        ),
    ]

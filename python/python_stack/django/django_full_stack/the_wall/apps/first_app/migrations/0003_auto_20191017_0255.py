# -*- coding: utf-8 -*-
# Generated by Django 1.10 on 2019-10-17 02:55
from __future__ import unicode_literals

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('first_app', '0002_auto_20191017_0134'),
    ]

    operations = [
        migrations.RenameField(
            model_name='message',
            old_name='User',
            new_name='user',
        ),
    ]

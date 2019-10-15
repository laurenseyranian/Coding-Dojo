from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^shows$', views.all_shows),
    url(r'^shows/new$', views.add_show),
    url(r'^shows/(?P<id>\d+)$', views.display_show),
    url(r'^shows/(?P<id>\d+)/edit$', views.edit_show),
    url(r'^shows/(?P<id>\d+)/delete$', views.delete_show),
]
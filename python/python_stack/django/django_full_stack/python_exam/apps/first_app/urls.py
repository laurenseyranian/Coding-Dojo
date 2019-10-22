from django.conf.urls import url
from . import views


urlpatterns = [
    url(r'^$', views.index),
    url(r'^register_user$', views.register_user),
    url(r'^login_user$', views.login_user),
    url(r'^logout$', views.logout),

    url(r'^dashboard$', views.dashboard),
    url(r'^trips/new$', views.add_trip),
    url(r'^create_trip$', views.create_trip),
    url(r'^trips/(?P<id>\d+)$', views.show_trip),
    url(r'^trips/(?P<id>\d+)/edit$', views.edit_trip),
    url(r'^update_trip$', views.update_trip),
    url(r'^trips/(?P<id>\d+)/delete$', views.delete_trip),
]
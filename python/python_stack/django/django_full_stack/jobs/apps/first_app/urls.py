from django.conf.urls import url
from . import views


urlpatterns = [
    url(r'^$', views.index),
    url(r'^register_user$', views.register_user),
    url(r'^login_user$', views.login_user),
    url(r'^logout$', views.logout),

    url(r'^dashboard$', views.dashboard),
    url(r'^jobs/new$', views.add_job),
    url(r'^create_job$', views.create_job),
    url(r'^jobs/(?P<id>\d+)$', views.show_job),
    url(r'^jobs/(?P<id>\d+)/edit$', views.edit_job),
    url(r'^update_job$', views.update_job),
    url(r'^jobs/(?P<id>\d+)/delete$', views.delete_job),
]
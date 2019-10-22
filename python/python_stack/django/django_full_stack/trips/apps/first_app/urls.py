from django.conf.urls import url
from . import views


urlpatterns = [
    url(r'^$', views.index),
    url(r'^register_user$', views.register_user),
    url(r'^login_user$', views.login_user),
    url(r'^logout$', views.logout),
    url(r'^dashboard$', views.dashboard),
    url(r'^add_trip$', views.add_trip),
    url(r'^create_trip$', views.create_trip),
    
    
    
    
    
    
#     url(r'^success$', views.success),
#     url(r'^success/(?P<id>\d+)$', views.view_book),
#     url(r'^add_book$', views.add_book),
#     url(r'^edit_book$', views.edit_book),
#     url(r'^delete/(?P<id>\d+)$', views.delete),
#     url(r'^book_details/(?P<id>\d+)$', views.book_details),
#     url(r'^logout$', views.logout),
]
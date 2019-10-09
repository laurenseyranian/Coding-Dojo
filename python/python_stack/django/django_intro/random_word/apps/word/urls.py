from django.conf.urls import url
from . import views
                    
urlpatterns = [
    url('^$', views.random),
    url('^reset$', views.reset),
]
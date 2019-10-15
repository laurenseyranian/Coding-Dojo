from django.conf.urls import url
from . import views

urlpatterns = [
    #book home page
    url(r'^$', views.add_book), 

    #add new book to home page
    url(r'^add_new_book$', views.add_new_book),

    #click the view button and view the book information
    url(r'^books/(?P<book_id>\d+)$', views.view_book_info),

    #view book information page
    url(r'^books/(?P<book_id>\d+)/add_author$', views.add_author_to_book),



    #add new author to home page
    url(r'^authors$', views.add_author),

    #add new author to home page
    url(r'^add_new_author$', views.add_new_author),

    #click the view button and view the author's information
    url(r'^authors/(?P<author_id>\d+)$', views.view_author_info),

    #view author information page
    url(r'^authors/(?P<author_id>\d+)/add_book$', views.add_book_to_author),
]

    
    
    
    
    
    
    
    
    
    # url(r'^authors$', views.authors),
    #  add author page
#     url(r'^authors/add_author$', views.add_author),
#     # add author

#     url(r'^books/add_book$', views.add_book),
#     url(r'^books/(?P<book_id>\d+)/add_author$', views.add_author_to_book),
#     url(r'^books/(?P<book_id>\d+)$', views.one_book),
#     url(r'^authors/(?P<author_id>\d+)$', views.one_author),
#     url(r'^authors/(?P<author_id>\d+)/add_book$',views.add_book_to_author),
# ]
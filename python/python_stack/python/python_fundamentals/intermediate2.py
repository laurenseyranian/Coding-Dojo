#1 Update Values in Dictionaries and Lists
    #Change the value 10 in x to 15. Once you're done, x should now be [ [5,2,3], [15,8,9] ].
    #Change the last_name of the first student from 'Jordan' to 'Bryant'
    #In the sports_directory, change 'Messi' to 'Andres'
    #Change the value 20 in z to 30
x = [ [5,2,3], [10,8,9] ] 
students = [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]
x[1][0]=15
print(x)

students[0]['last_name']='Bryant'
print(students[0]['last_name'])

sports_directory['soccer'][0]='Andres'
print(sports_directory['soccer'][0])

z[0]['y']=30
print(z)

#2 Iterate Through a List of Dictionaries
    # should output: (it's okay if each key-value pair ends up on 2 separate lines;bonus to get them to appear exactly as below!)
        #first_name - Michael, last_name - Jordan
        #first_name - John, last_name - Rosales
        #first_name - Mark, last_name - Guillen
        #first_name - KB, last_name - Tonel
students = [
         {'first_name':  'Michael', 'last_name' : 'Jordan'},
         {'first_name' : 'John', 'last_name' : 'Rosales'},
         {'first_name' : 'Mark', 'last_name' : 'Guillen'},
         {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]
def iterateDictionary(list):
    for i in range(0,len(list),1):
        print (list[i])
iterateDictionary(students)

#3 Get Values From a List of Dictionaries
    #Michael
    #John
    #Mark
    #KB

    #Jordan
    #Rosales
    #Guillen
    #Tonel

def iterateDictionary(key_name, list):
    for i in range(0,len(list),1):
        print(list[i][key_name])
iterateDictionary('first_name', students)

def iterateDictionary2(key_name, list):
    for i in range(0,len(list),1):
        print(list[i][key_name])
iterateDictionary2('last_name', students)

#4 Iterate Through a Dictionary with List Values
    # output:
        #7 LOCATIONS
        #San Jose
        #Seattle
        #Dallas
        #Chicago
        #Tulsa
        #DC
        #Burbank
        #    
        #8 INSTRUCTORS
        #Michael
        #Amy
        #Eduardo
        #Josh
        #Graham
        #Patrick
        #Minh
        #Devon

dojo = {
    'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
    'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh','Devon']
}
def printInfo(some_dict):
    for key in some_dict:
        print(str(len(some_dict[key])) + " " + key.upper() + "\n")
        for value in some_dict[key]:
            print(value)
        print()
printInfo(dojo)
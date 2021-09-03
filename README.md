### Book Management system

#### main options
- users are: Admin, Author, ordinary User
- admin has all privilages related to users such as add, edit, delete
- the author can add, edit, delete books
- users can see the books by their creation time or realse year
- users can search books by keywords
- users can filter books by author, publisher, release period
- the responses are paginated
- there are 3 modules: Book, Search, authentication
- data saved in postgresql 

#### advanced option
- using spring data JPA for interaction with database

#### notes
```diff
- the project is implemented by MVC architecture
- all modules interact with RESTFUL API
- JSP (java server pages) used for view

### details

#### Book
- configuration for database are in application.properties 
- bookcontroller has all the routes for showing the books paginated/sorted, showing details of a book, add, delete, edit
- all http methods(get, post, delete, update) used for controlling books
- the main operations are done in Bookservice class which interacts with BookRepository

#### Search
- this module communicates with Book using restTemplate
- firstly we fetch all books ans save them in bookWrapper and use them is search and filter

#### Authentication
- the  main module which communicates with Book and Search
- controller package is for monitoring user, publisher, admin tasks
- Publisher/User Controller fetch their information from Search and Book
- AdminController requests the User entity defined in this module for modifying users
- spring security is used for authentication manners

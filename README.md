# MVVM-using-Java

- News Application using MVVM.

## What is MVVM?

- MVVM stands for Model View ViewModel and it is a design pattern that is used to build softwares applications.
- MVVM helps us to separate the Business Logic of our Application from the Views or UI.
- It losses the tight coupling between each component.
- Works on the concept of observables.
- Children don't have reference to the parent, they only have reference by observables.

__Model__

- This is responsible for handling the data in the application. 
- It is business logic and Data State. 
- Model cannot directly interact with Views, but it interacts with ViewModels and then Views with the help of observables.

__View__

- This is the User Interface of our Application. 
- It should not contain any application logic.

__ViewModel__

- It is basically a link between Model and View.

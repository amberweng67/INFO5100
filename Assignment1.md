# ///Case 1///
## Design a course management system (Like Canvas);

Teacher 
Data: name, teacherId, emailAddress, loginCredentials 
Behavior: login, uploadCourse, assignHomework, sendNotice, uploadSyllabus, giveGrade, setDueDate

Student
Data: name, studentId, emailAddress, loginCredentials 
Behavior: logIn, uploadHomework, reviewNotice, checkGrade, checkCourse, getSyllabus

Course
Data: name, courseId, courseSchedule 
Behavior:

Homework
Data: words, image, dueDate
Behavior:

Online Platform
Data: course
Behavior: checkCredentials, deliverNotice, deliverHomeworkToStudent, deliverHomeworkToTeacher, deliverGrade, disableUploadHomework   

///Sequence of invoking behaviors on objects///
```
Student amber;
OnlinePlatform canvas;
Teacher siva;
Course 5100;
amber.login(studentId, loginCredentials);
if 5100 hasHomework
  homework = canvas.deliverHomeworkToStudent();
  if currentTime > homework.dueDate
    homework = amber.uploadHomework();
    canvas.deliverHomeworkToTeacher(siva, homework);
    siva.giveGrade(amber, homework);
    canvas.deliverGrade(amber, homework);
  else
    homework passedDue
    canvas.disableUploadHomework();

else 5100 noHomework
```

# ///Case 2///
## Design a pet adoption platform
Pet
Data: name, breed, color, sex, health, adoptionFee 
Behavior:

Adoption Platform
Data: pets
Behavior: provideApplication, sendApplication, provideConfirmation, processAdoptionFee

Adopter
Data: name, phone, income, job, address
Behavior: fillApplication, viewPets, pickUpPet, receiveConfirmation, sendAdoptionFee  

Pet Provider
Data: name
Behavior: reviewApplication, sendConfirmation, listPets, listRequirement, receiveAdoptionFee, approveApplication, cancelApplication 

///Sequence of invoking behaviors on objects///
```
Adopter amber;
PetProvider paws;
AdoptionPlatform findPet;
Pet cat = amber.viewPets(name, breed, color, sex, health, adoptionFee );
amber.fillApplication(cat)
findPet.sendApplication（amber.name, amber.phone, amber.income, amber.job, amber.address）;
paws.reviewApplication（amber.name, amber.phone, amber.income, amber.job, amber.address）;
if amber meetRequirement
  paws.approveApplication();
  amber.sendAdoptionFee();
  isPaymentFulfilled = findPet.processAdoptionFee();
  if isPaymentFulfilled
    paws.receiveAdoptionFee();
    paws.sendConfirmation();
    amber.pickUpPet();
  else 
    paws.cancelApplication();
else
 paws.cancelApplication();
```

# ///Case 3///
## Design an app to book airline ticket.
<!-- Travel Agency
Data: 
Behavior: -->

Airline 
Data: flights, 
Behavior: uploadFlight, approvePurchase, 

Flight
Data: date, time, airPlane, departureAirport, arrivalAirport, duration, ticketsNumber
Behavior:

Traveler 
Data: id, birthDate, creditCard, email
Behavior: logIn, buy, requestCancelOrder, requestRefund, Search,

TicketPlatform
Data: flights
Behavior: sendReceipt, checkOut, refund,

///Sequence of invoking behaviors on objects///
```
Traveler amber;
TicketPlatform expedia;

amber.logIn();
Flight flight = amber.search(date, time, departureAirport, arrivalAirport);
if expedia hasFlight
  amber.buy(flight);
  expedia.checkOut(amber.id, amber.birthDate, amber.creditCard);
  expedia.sendReceipt(amber.email);
  if amber change her mind
    amber.requestCancelOrder(flight);
    expedia.refund(flight, amber);
else expedia hasNoFlight
```

# ///Case 4///
## Design a course registration platform.

Teacher 
Data: name, id
Behavior:

Student
Data: name, id, email, finishedCourses
Behavior: search, login, registerCourse, dropCourse

Course 
Data: schedule, seat, name, time, semester, prerequisites, teacher
Behavior:

RegistrationPlatform
Data: courses
Behavior: confirmRegistration, confirmDrop, sendConfirmation

///Sequence of invoking behaviors on objects///
```
Student amber;
RegistrationPlatform myNEU;
amber.login();
Course course = amber.search(teacher, schedule, name, time, semester);
if myNEU hasSeat and amber hasMeetPrerequisitesOfCourse
  amber.registerCourse(course);
  myNEU.confirmRegistration(course, amber);
  myNEU.sendConfirmation(amber.email);
  if amber change her mind
    amber.dropCourse(course);
    myNEU.confirmDrop(course, amber);
else course hasNoSeat or amber hasNotTakenPrerequisites
```

# ///Case 5///
## Order food in a food delivery app.(Like Uber Eats)
Customer
Data: emailAddress, name, loginCredentials, address, phone, creditCard
Behavior: search, order, logIn, cancelOrder, writeReview, eat

Driver
Data: car, name, phone, review
Behavior: pickup, deliver, call

Restaurant 
Data: name, location, openTime, cuisine, reviews, dishes
Behavior: acceptOrder, cook,

Car
Data: licenseNumber, manufacture, color
Behavior:

Address
Data:
Behavior:

DeliveryApp
Data: restaurants
Behavior: sendReceipt, sendOrderToRestaurant, cancelOrder, refund

///Sequence of invoking behaviors on objects///
```
Customer amber;
DeliveryApp uberEats;

amber.logIn(loginCredentials);
Restaurant restaurant = amber.search(name, location, openTime, cuisine, reviews, dishes);
if uberEats findRestaurant 
  amber.order(restaurant, creditCard, address);
  uberEats.sendReceipt(amber);
  uberEats.sendOrderToRestaurant(restaurant);
  if restaurant acceptOrder
    Driver driver = uberEats.assignDriver(restaurant, amber.address, amber.phone);
    if restaurant hasFinishedCook
      driver.pickup(restaurant);
      driver.deliver(amber.address, amber.phone);
      if driver cannotFindAmberAddress
        driver.call(amber.phone);
      if amber getDelivery
        amber.eat();
        amber.writeReview();
      else amber wait
    else driver wait
  else
    uberEats.cancelOrder(amber);
    uberEats.refund(amber);
```

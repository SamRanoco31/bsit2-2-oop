# LICEO RIDE - Semi-Final Laboratory Exam Answers
Name: Sam Alexis B. Ranoco

Section: BSIT 2-2

## Question 1
Why is the list in RideManager typed ArrayList&lt;Ride&gt; and not ArrayList&lt;Jeepney&gt;?
Your answer:

It can store different types of rides becase the Jeepney, Tricycle, and Taxi are all inherited from ride. This allows RideManager to manage all different vehicles using one list.
## Question 2
In showStudentDiscounts(), why must you check instanceof before the cast?
Your answer:

Because the instanceof are able to check making sure that the ride actually implements StudentDiscount before casting it.
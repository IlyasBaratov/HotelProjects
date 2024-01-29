from combining import Combine
app = Combine()
app.serching()
# chosing = int(input("Which one would you like to choose? (enter numbers) "))
# app.choosing(chosing)
rooms_amount = int(input("How many rooms would you like to book? "))
app.payment_proccess(rooms_amount)
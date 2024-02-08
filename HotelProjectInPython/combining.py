import sqlite3
import sys
from client_controller import Client
from hotel_controller import Hotel



class Combine:
    id = []
    answer = []



    def searching():
        conn = sqlite3.connect("hotel_data.db")
        cursor = conn.cursor()
        selections = cursor.execute("SELECT ID_number, hotel_name FROM hotel")
        
        id = selections.fetchone()[0]
        name = selections.fetchone()[1]
        print(id)
        print(name)

    # def serching(self):
    #     conn = sqlite3.connect("hotel_data.db")
    #     conn2 = sqlite3.connect("hotel_data.db")
    #     cursor = conn.cursor()
    #     cursor2 = conn2.cursor()
    #     name = []

    #     id_selection = cursor2.execute("SELECT ID_number FROM hotel")
    #     name_selection = cursor.execute("SELECT hotel_name FROM hotel")

    #     id_total = id_selection.fetchall()
    #     name_total = name_selection.fetchall()
    #     rows = len(id_total)
    #     number = 0
    #     for row in range(rows):
    #         self.id.append(id_total[row][0])
    #         name.append(name_total[row][0])
    #     asking = input("Would you like to search by ID or Name? ").lower()
    #     if asking == ("id"):
    #         ID_request = int(input("Enter the ID number of the hotel! "))
    #         number = self.id.index(ID_request) + 1
    #     elif asking == ("name"):
    #         name_request = input("Enter the name of the city! ").upper()
    #         number = name.index(name_request)
    #     else:
    #         print("wrong message")
    #         sys.exit()
    #     self.choosing(number)

    def choosing(self, number):
        conn = sqlite3.connect("hotel_data.db")
        cursor = conn.cursor()
        chosen = self.id[number]
        raw_answer = cursor.execute(f"SELECT * FROM hotel WHERE ID_number = {chosen};")
        self.answer = raw_answer.fetchall()[0]
        print(self.answer)
        print(
            "Name:    ",
            self.answer[3],
            "\nRooms:    ",
            self.answer[4],
            "\nPrice:    ",
            self.answer[5],
        )

    def payment_proccess(self, rooms_amount):
        client = Client()
        number = self.answer[5]
        id_number = self.answer[0]
        conn = sqlite3.connect("hotel_data.db")
        conn2 = sqlite3.connect("client_bank_acc.db")
        cursor2 = conn2.cursor()
        cursor = conn.cursor()
        total_price = number * rooms_amount
        total = self.checking_clents_account(total_price)
        client.set_deposit(0)
        total -= total_price

        client.set_expenses(total_price)
        client.set_total(client.get_deposit(), client.get_expenses())
        if self.answer[4] - rooms_amount >= 0:
            cursor.execute(
                f"UPDATE hotel SET available_rooms = ? WHERE ID_number = {id_number}",
                (self.answer[4] - rooms_amount,),
            )
            cursor2.execute(
                "INSERT INTO clients (first_name, last_name, date, deposit, expenses, total) VALUES (?, ?, ?, ?, ?, ?)",
                (
                    client.get_first_name(),
                    client.get_last_name(),
                    client.get_date(),
                    client.get_deposit(),
                    client.get_expenses(),
                    client.get_total()
                )
            )
            print(
                f"""ORDER DITAILS:
                            Rooms: {rooms_amount}
                            TOTAL PRICE: {client.get_total()}
                            DATE OF PURCHASE: {client.get_date()}
                            CLIENT NAME : {client.get_first_name()} {client.get_last_name()}"""
            )
        else:
            print(
                "NOT ENOUGH AVAILABLE ROOMS. RUN THE PROGRAMM AGAIN IF YOU WANT TO MAKE ANOTHER BOOKING"
            )
            sys.exit()
        conn.commit()
        conn2.commit()

    def checking_clents_account(self, total_amount):
        conn = sqlite3.connect("client_bank_acc.db")
        cursor = conn.cursor()
        raw_total = cursor.execute("Select total from clients")
        total_money = raw_total.fetchall()[-1][0]
        if total_amount > total_money:
            print("ERROR! NOT ENOUGH MONEY IN YOUR BANK ACCOUNT")
            sys.exit()
        else:
            return total_money
    
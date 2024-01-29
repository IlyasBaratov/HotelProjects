from datetime import datetime
import sqlite3
import math
class Client:
    def __init__(self, date="", deposit=0, expenses=0, total=0):
        self.date = date
        self.deposit = deposit
        self.expenses = expenses
        self.total = total


    def get_date(self):
        current_date = datetime.now()
        formatted_date = current_date.strftime("%b %d,%Y")
        return formatted_date
    def get_first_name(self):
        return "Ilyas"
    def get_last_name(self):
        return "Baratov"
        

    def get_deposit(self):
        return self.deposit

    def set_deposit(self, new_deposit):
        self.deposit = new_deposit

    def get_expenses(self):
        return self.expenses

    def set_expenses(self, new_expenses):
        self.expenses = new_expenses

    def get_total(self):
        return self.total

    def set_total(self,deposit, expenses):
        
        conn = sqlite3.connect("client_bank_acc.db")
        cursor = conn.cursor()
        raw_total = cursor.execute("Select total from clients")
        total_money = raw_total.fetchall()[-1][0]
        total_2 = (round(total_money + deposit - expenses))

        self.total = total_2
        conn.commit()
        conn.close()
    
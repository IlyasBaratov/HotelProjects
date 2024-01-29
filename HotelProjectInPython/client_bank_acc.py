import sqlite3
from client_controller import Client
app = Client()
conn = sqlite3.connect(".client_bank_acc.db")
cursor = conn.cursor()
cursor.execute('''
    CREATE TABLE IF NOT EXISTS clients (
               first_name TEXT,
               last_name TEXT,
               date TEXT,
               deposit INTEGER,
               expenses INTEGER,
               total INTEGER
    )
''')


rows = cursor.execute("SELECT total FROM clients")
date = app.get_date()
app.set_deposit(int(input("enter your deposit: ")))
app.set_expenses(int(input("enter your expenses: ")))
app.set_total(app.get_deposit(), app.get_expenses())

cursor.execute("INSERT INTO clients (first_name, last_name, date, deposit, expenses, total) VALUES (?, ?, ?, ?, ?, ?)",
    (app.get_first_name(), app.get_last_name(), app.get_date(), app.get_deposit(), app.get_expenses(), app.get_total()))

print("DONE!")
conn.commit()
class Hotel:
    # def __init__(self, id, city, country, hotel_name, available_rooms, price_per_night):
    #     self._id = id
    #     self._city = city
    #     self._country = country
    #     self._hotel_name = hotel_name
    #     self._available_rooms = available_rooms
    #     self._price_per_night = price_per_night


    def get_id(self):
        return self._id

    def set_id(self, value):
        self._id = value

    def get_city(self):
        return self._city

    def set_city(self, value):
        self._city = value

    def get_country(self):
        return self._country

    def set_country(self, value):
        self._country = value

    def get_hotel_name(self):
        return self._hotel_name

    def set_hotel_name(self, value):
        self._hotel_name = value

    def get_available_rooms(self):
        return self._available_rooms

    def set_available_rooms(self, value):
        self._available_rooms = value

    def get_price_per_night(self):
        return self._price_per_night

    def set_price_per_night(self, value):
        self._price_per_night = value

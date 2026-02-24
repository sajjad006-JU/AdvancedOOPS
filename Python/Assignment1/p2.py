# 2.  Write  a  discount  coupon  code  using  dictionary in Python with different rate coupons for 
# each day of the week. 
# Sajjad Ahmed Shaaz, 002410501093

DISCOUNT_COUPONS = {
    "Monday": {"code": "MDY10", "rate": 10},
    "Tuesday": {"code": "TUE20", "rate": 10},
    "Wednesday": {"code": "WED30", "rate": 30},
    "Thursday": {"code": "THURS10", "rate": 10},
    "Friday": {"code": "FRI20", "rate": 20},
    "Saturday": {"code": "SAT10", "rate": 10},
    "Sunday": {"code": "SUPERSUNDAY", "rate": 50},
}

day = input()
# for day in DISCOUNT_COUPONS:
print(day, " Code", DISCOUNT_COUPONS[day]["code"], " rate: ", DISCOUNT_COUPONS[day]["rate"])
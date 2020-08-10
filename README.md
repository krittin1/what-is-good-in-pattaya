# "What is good in pattaya" Presents ... The Readme.

## Convention Web UI

## Common Convention

- โค้ดการทำงานหนึ่งบรรทัด มีการใส่ Semi-colon `;`

```
console.log(this.test);
```

- String จะใช้ Double quote

```
var sampleString = "What is good in Pattaya?";
```

- Class name เป็น Pascal Case

```
class SampleClass {}
```

## Function And Parameter Naming Conventions

- ส่วนที่เป็นการคำนวน จะใช้รูปแบบการตั้งชื่อแบบ **camelCase ขึ้นต้นต้วยตัวพิมพ์เล็ก**

```
function getTotalProduct(age: number, gender: string) {}
```

## HTML Element ID

- จะใช้รูปแบบการตั้งชื่อแบบ **Snake Case ขึ้นต้นต้วยตัวพิมพ์เล็ก และขั้นคำด้วยเครื่องหมาย \_**

```
first_name
what_is_good_in_pattaya
```

## Directory Name

- ใช้ Kebab Case โดยเริ่มด้วยตัวพิมพ์เล็ก และขั้นคำด้วยเครื่องหมาย -

```
order
product
product-order
```

## File Name

- ใช้ Kebab Case โดยเริ่มด้วยตัวพิมพ์เล็ก และขั้นคำด้วยเครื่องหมาย -

```
order.ts
shipping-component.test.ts
```

## Variable Name

- ใช้ Camel case

```
product, firstName. productDetail
```

- ตัวแปรที่ใช้เก็บค่าหลายตัว ให้เติมคำว่า List ต่อท้ายด้วย

```
productList
```

- ชื่อตัวแปร Constant เป็นตัวอักษรพิมพ์ใหญ่ทั้งหมด ในรูปแบบ Snake Case (All Caps) เช่น

```
SHIPPING_FEE, PATTAYA
```

## Robot Framework convention

### File name

- ใช้ Kebab Case โดยเริ่มด้วยตัวพิมพ์เล็ก และขั้นคำด้วยเครื่องหมาย -

```
keywords.robot
success-keyword.robot
success.robot
alternative.robot
```

---

# Convention Web Service

## Function And Parameter Naming Conventions

- ใช้รูปแบบการตั้งชื่อฟังก์ชั่นแบบ **camelCase ขึ้นต้นต้วยตัวพิมพ์เล็ก**

```
double computeTax()
```

## Package Name

- ใช้ตัวอักษรพิมพ์เล็กทั้งหมด ในรูปแบบ Snake Case

```
product_detail
product_controller
```

## File Name

- Pascal Case ขึ้นต้นด้วยตัวใหญ่ เช่น

```
UserController.java
ProductRepository.java
```

## Test Function Name

- ใช้รูปแบบการตั้งชื่อฟังก์ชันเป็นแบบ **Snake_Case** เช่น

```
Test_CalculateAge_Input_Birth_Date_18042003_Should_be_16
```

## Variable Name

- ชื่อตัวแปรเป็นคำเดียวให้ตั้งชื่อเป็นพิมพ์เล็กทั้งหมด เช่น

```
day, month, year
```

- ชื่อตัวแปรมีความยาวตั้งแต่ 2 คำขึ้นไป ให้คำหลังขึ้นตันด้วยตัวอักษรตัวใหญ่เสมอ ในรูปแบบ **camelCase** เช่น

```
startDay, endMonth
```

- ชื่อตัวแปรเก็บค่าให้เติม "List" ต่อท้ายตัวแปรเสมอ เช่น

```
orderList
```

- ชื่อตัวแปร Constant ให้ตังชื่อเป็นตัวอักษรพิมพ์ใหญ่ทั้งหมด เช่น

```
HOUR, MINUTE
```

---

## ข้อตกลง Commit Message ร่วมกัน

```
[Created]: สร้างไฟล์ใหม่สำหรับ...

[Edited]: แก้ไข code ในไฟล์เดิมที่มีอยู่แล้ว รวมถึงกรณี refactor code

[Added]: กรณีเพิ่ม function, function test ใหม่เข้ามา

[Deleted]: ลบไฟล์ออก 'ชื่อไฟล์' เนื่องจาก...

* ให้เขียนรายละเอียดด้วยว่าแก้ไขอะไรและทำที่ตรงไหน
```

## How to run Acceptance test (API and UI)

### API test

1. ติดตั้ง newman

```
npm install -g newman
```

2. คำสั่งที่ใช้ run newman

```
newman run atdd/api/shopping_cart_success.json -e atdd/api/environment/local_environment.json -d atdd/api/data/shopping_cart_success.json
```

หรือใช้คำสั่งย่อ

```
make run_newman
```

### UI test

1. ติดตั้ง Robot framework

```
download Python2.7.xx (www.python.org)
```

2. ติดตั้ง PIP

```
sudo easy_install pip
```

3. ติดตั้ง Robot framework

```
pip install robotframework
```

4. ติดตั้ง selenium2library

```
pip install robotframework-selenium2library
```

5. ติดตั้ง chrome driver

```
brew install chromedriver
```

6. run robot framework

```
robot atdd/ui/shopping_cart_success.robot
```

หรือใช้คำสั่งย่อ

```
make run_robot
```

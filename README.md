# "What is good in pattaya" Presents ... The Readme

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

# Convention Web Service (Backend)

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

## Test Function Name (JUnit Test)

- ใช้รูปแบบการตั้งชื่อฟังก์ชันเป็นแบบ **snake_case** เช่น

```
test_compute_tax_should_return_double_greater_or_equal_to_zero()
```

## Variable Name

- ใช้ Camel case

```
product, firstName, productDetail
```

- ตัวแปรที่ใช้เก็บค่าหลายตัว ให้เติมคำว่า List ต่อท้ายด้วย

```
productList
```

- ชื่อตัวแปร Constant เป็นตัวอักษรพิมพ์ใหญ่ทั้งหมด ในรูปแบบ Snake Case (All Caps) เช่น

```
SHIPPING_FEE, PATTAYA
```

---

## ข้อตกลง Commit Message ร่วมกัน

```
[Created]: สร้างไฟล์ใหม่สำหรับ...

[Edited]: แก้ไข code, Refactor (บอกส่วนที่แก้ไข หรือ refactor ด้วย)

[Added]: กรณีเพิ่มเติมอะไรก็ตามในไฟล์ **ที่มีอยู่แล้ว**

[Deleted]: ลบไฟล์ออก 'ชื่อไฟล์' เนื่องจาก...  (สำหรับลบไฟล์เท่านั้น)

* ให้เขียนรายละเอียดด้วยว่าแก้ไขอะไรและทำที่ตรงไหน
```

```
git commit -m '[Created] : Product.java'
git commit -m '[Added] new function in Math.java'

```

### UI test

1. ติดตั้ง Robot framework

```

download Python3.8.xx (www.python.org)

```

2. ติดตั้ง Robot framework

```

pip install robotframework

```

3. ติดตั้ง seleniumlibrary

```

pip install robotframework-seleniumlibrary

```

4. ติดตั้ง chrome driver

### On MacOS

```

brew install chromedriver

```

### On Windows

โหลด chromedriver โดยใช้เวอร์ชันที่ตรงกับ Google Chrome บนเครื่อง

[Google chromedriver](https://chromedriver.chromium.org/downloads)

6. run robot framework

```

robot tests/e2e/success/success.robot

```

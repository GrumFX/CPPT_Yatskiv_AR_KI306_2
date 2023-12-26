import math
import struct
import os

class Calc:
    def __init__(self):
        self.result = 0.0

    def calculate(self, x):
        if x == 90 or x == -90:
            print("You entered incorrect values")
            exit(0)
        else:
            radians = math.radians(x)
            self.result = math.tan(radians)

    def get_result(self):
        return self.result

    def write_res_txt(self, file_name):
        try:
            with open(file_name, 'w') as file:
                file.write(f"{self.result}")
        except FileNotFoundError as ex:
            print(ex)

    def read_res_txt(self, file_name):
        try:
            with open(file_name, 'r') as file:
                self.result = float(file.read())
        except FileNotFoundError as ex:
            print(ex)

    def write_res_bin(self, file_name):
        try:
            with open(file_name, 'wb') as file:
                file.write(struct.pack('>d', self.result))
        except FileNotFoundError as ex:
            print(ex)

    def read_res_bin(self, file_name):
        try:
            with open(file_name, 'rb') as file:
                self.result = struct.unpack('>d', file.read(8))[0]
        except FileNotFoundError as ex:
            print(ex)

    def writeNum(data, file_name):
            try:
                with open(file_name, 'w') as file:
                    file.write(f"{data.result}")
            except FileNotFoundError as ex:
                print(ex)
    

def main():
    obj = Calc()

    target_directory = "C:/Users/Adriyan/Desktop/PythonLabs/Lab8"
    os.chdir(target_directory)

    data = int(input("Enter data: "))

    with open("num.txt", 'w') as file:
         file.write(f"{data}")

    obj.calculate(data)
    print(f"Result is: {obj.get_result()}")
    obj.write_res_txt("textRes.txt")
    obj.write_res_bin("BinRes.bin")
    obj.read_res_bin("BinRes.bin")
    print(f"Result from bin: {obj.get_result()}")
    obj.read_res_txt("textRes.txt")
    print(f"Result from txt: {obj.get_result()}")


if __name__ == "__main__":
    main()
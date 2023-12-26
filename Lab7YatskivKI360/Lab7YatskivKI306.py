import os


input_file_path = "num.txt"
nROWS = int(input("Введіть розмір квадратної матриці: "))
symbol = input("Введіть символ-заповнювач: ")

if nROWS % 2 != 0:
    print("Збільшення розміру матриці на 1 для отримання квадрату.")
    nROWS += 1

with open("MyFile.txt", "w") as fout:
    fout.write("Matrix size: " + str(nROWS) + "\n")
    fout.write("Symbol: " + symbol + "\n")

    if len(symbol) != 1:
        print("\nСимвол-заповнювач введено невірно.")
        fout.write("\nСимвол-заповнювач введено невірно")
        exit(0)

    arr = []

    for i in range(nROWS):
        if i < nROWS // 2:    
            for middle in range(nROWS // 2, 0, -1):
                print("  ", end="")
                fout.write(" ")                 
            row = [symbol] * (nROWS // 2 )
            arr.append(row)
            print(" ".join(row))
            fout.write(" ".join(row) + "\n")
        else:
            row = [symbol] * (nROWS // 2)           
            arr.append(row)
            print(" ".join(row))
            fout.write(" ".join(row) + "\n")

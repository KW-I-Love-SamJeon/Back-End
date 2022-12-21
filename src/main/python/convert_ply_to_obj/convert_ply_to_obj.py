import sys
import os

def main():
    input_file = sys.argv[1]
    output_file = sys.argv[2]

    os.system("meshio convert %s %s " %(input_file, output_file))
    
if __name__ == '__main__' :
    main()
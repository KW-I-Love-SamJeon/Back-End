import sys
import meshio
def main():
    input_file = sys.argv[1];
    output_file = sys.argv[2];
    mesh = meshio.read(input_file)
    mesh.write(output_file);


if __name__ =='__main__':
    if(len(sys.argv)!=3) :
        print("parameter error")
    else :main()
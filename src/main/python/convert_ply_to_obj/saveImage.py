import datetime
import time
from time import sleep

from picamera import PiCamera

savepath = 'C:\\SW_project\\Back-End\\convert_ply_to_obj\\'


def capture3Minutes():    
    with picamera.Picamera() as camera :
        camera.resolution = (1920,1080)
        now = time.perf_counter_ns()
        camera.capture(savepath+now+'.png')
        sleep(0.05)
        
        print(now)
        
start = time.perf_counter()
end = time.perf_counter()
while end-start == 180:
    capture3Minutes()
    end= time.perf_counter()
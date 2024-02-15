from mrjob.job import MRJob
class MRWordFrequencyCount(MRJob):
    def mapper (self,_,line):
        (location,date,type,data,x,y,z,w)=line.split(',')
        if (type=='TMAX'):
            yield location,int(data) 
    def reducer (self,key,values):
        yield key,max(values)
if __name__=='__main__':
    MRWordFrequencyCount.run()
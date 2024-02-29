from mrjob.job import MRJob
class CalculTotal(MRJob):
    def mapper(self,_,line):
        words=line.split(",")
        yield words[0],float(words[2])
    def reducer (self,key,values):
        yield key ,round(sum(values),2)
if __name__=="__main__":
    CalculTotal.run()
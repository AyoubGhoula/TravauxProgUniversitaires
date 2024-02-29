from mrjob.job import MRJob
class CalculTotal(MRJob):
    def mapper(self,_,line):
        words=line.split(",")
        yield words[0],float(words[2])
    def combiner(self,key,values):
        occ=0
        n=0
        for i in values:
           occ+=i
           n+=1
        yield key,round(occ/n,3)
    def reducer (self,key,values):
        occ=0
        n=0
        for i in values:
           occ+=i
           n+=1
        yield key,round(occ/n,3)
if __name__=="__main__":
    CalculTotal.run()
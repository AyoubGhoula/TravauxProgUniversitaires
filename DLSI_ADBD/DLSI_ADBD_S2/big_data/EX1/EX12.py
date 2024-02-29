from mrjob.job import MRJob
from mrjob.job import MRStep
class CalculTotal(MRJob):
    def steps(self):
        return[MRStep(mapper=self.mapper,
                      reducer=self.reducer),
                MRStep(mapper=self.mapper_make_amounts_key,reducer=self.reducer_output_results)] 

    def mapper(self,_,line):
        words=line.split()
        yield words[0],int(words[2])
    def reducer (self,key,values):
        yield key ,sum(values)
    def mapper_make_amounts_key(self,word,count):
        yield None , (count,word)
    def reducer_output_results(self,orderTotal,customerIDs):
        print("hii")
if __name__=="__main__":
    CalculTotal.run()
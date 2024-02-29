from mrjob.job import MRJob
from mrjob.job import MRStep
class CalculTotal(MRJob):
    def steps(self):
        return[MRStep(mapper=self.mapper_get_orders,
                      reducer=self.reducer_totals_by_customer),
                MRStep(mapper=self.mapper_make_amounts_key,reducer=self.reducer_output_results)] 
    def mapper_get_orders(self,_,line):
        words=line.split(',')
        yield words[0],float(words[2])
    def reducer_totals_by_customer(self,word,values):
        occ=0
        n=0
        for i in values:
           occ+=i
           n+=1
        yield word,round(occ/n,3)
    def mapper_make_amounts_key(self,word,count):
        yield count, word
    def reducer_output_results(self,orderTotal,customerIDs):
        for customerID in customerIDs:
            yield orderTotal,customerID
if __name__=="__main__":
    CalculTotal.run()
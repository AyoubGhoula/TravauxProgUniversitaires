from mrjob.job import MRJob
class MRWordFrequencyCount(MRJob):
    def mapper (self,_,line):
        words=line.split()
        rating=words[2]
        yield rating,1
    def reducer (self,key,values):
        yield key,sum(values)
if __name__=='__main__':
    MRWordFrequencyCount.run()
from mrjob.job import MRJob
class MRWordFrequencyCount(MRJob):
    def mapper (self,_,line):
        words=line.split(',')
        yield words[2],int(words[3])
    def reducer (self,key,values):
        n=0
        c=0
        for i in values:
            n+=1
            c+=i
        yield key,(c/n)
if __name__=='__main__':
    MRWordFrequencyCount.run()
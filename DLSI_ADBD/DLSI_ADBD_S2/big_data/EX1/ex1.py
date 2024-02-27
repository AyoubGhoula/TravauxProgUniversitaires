from mrjob.job import MRJob
class MRRatingCounter(MRJob):
    def mapper(self,_, line):
        words=line.split(',')
        yield words[2],int(words[3])
    def reducer(self, key, values):
        n=0
        occ=0
        for i in values:
            n+=1
            occ+=i      
        yield key,occ/n
if __name__=="__main__":
    MRRatingCounter.run()      

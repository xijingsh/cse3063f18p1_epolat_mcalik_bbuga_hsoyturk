from collections import Counter
import re

import matplotlib.pyplot as plt
import csv

from nltk.corpus import stopwords
from wordcloud import WordCloud
import math


class TextMining:
    def __init__(self):
        self.stop_words = set(stopwords.words('english'))

    def openfile(self, filename):
        fh = open(filename, "r+")
        str = fh.read()
        fh.close()
        return str

    def removegarbage(self, str):
        # Replace one or more non-word (non-alphanumeric) chars with a space
        str = re.sub(r'\W+', ' ', str)
        str = str.lower()
        return str

    def getwordbins(self, words):
        cnt = Counter()
        for word in words:
            cnt[word] += 1
        return cnt

    def tf_value(self, filename, topwords, word):
        file = open("tf_list.csv", "a")
        txt = self.openfile(filename)
        txt = self.removegarbage(txt)
        words = txt.split(" ")
        bins = self.getwordbins(words)
        maximum = 0
        i = 0
        for key, value in bins.most_common(topwords):
            if i == 0:
                maximum = value
            tf_value = value / maximum
            if key == word:
                return tf_value
            i += 1
            if i == 50: break
        file.close()
        return tf_value

    def idf_value(self, filename, topwords, word):
        total_count = 0
        documents = 'document'
        i = 1
        for i in range(6):
            if (i == 0):
                i += 1
            txt = self.openfile(documents + str(i) + '.txt')
            txt = self.removegarbage(txt)
            words = txt.split(" ")
            if word in words:
                total_count += 1
            i += 1
            if i == 6:
                break;
        return math.log(1 + (5 / total_count))

    def tf_list_csv(self, filename, topwords):
        file = open("tf_list.csv", "a")
        txt = self.openfile(filename)
        txt = self.removegarbage(txt)
        words = txt.split(" ")
        bins = self.getwordbins(words)
        maximum = 0
        i = 0
        for key, value in bins.most_common(topwords):
            if i == 0:
                maximum = value
            tf_value = value / maximum
            file.write(key + " , " + str(tf_value) + "\n")
            i += 1
            if i == 50: break
        print("tflist ok!")
        file.close()
        file2 = open("tfidf_list.csv", "a")
        open('tfidf_list.csv', 'w').close()
        file2.close()
    
    def tfidf_list_csv(self, filename, topwords):
        file2 = open("tfidf_list.csv", "a")
        txt = self.openfile(filename)
        txt = self.removegarbage(txt)
        words = txt.split(" ")
        bins = self.getwordbins(words)
        i = 0
        for key, value in bins.most_common(topwords):
            tf = self.tf_value(filename, topwords, key)
            idf = self.idf_value(filename, topwords, key)
            file2.write(key + " , " + str(tf * idf) + "\n")
            i += 1
            if i == 50: break
        print("tfidf ok!")
        file2.close()

    def world_cloud(self, filename):
        file3 = open(filename, "r")
        csvReader = csv.reader(file3)
        wordList = list(csvReader)
        toWorldCloud = ""
        for row in wordList:
            for word in row:
                toWorldCloud = toWorldCloud + " " + word

        wordcloud = WordCloud(width=800, height=800,
                              background_color='white',

                              min_font_size=10).generate(toWorldCloud)

        plt.figure(figsize=(8, 8))
        plt.imshow(wordcloud)
        plt.axis("off")
        plt.tight_layout(pad=0)
        plt.savefig('wordcloud' + str(filename) + '.pdf')
        plt.show()

    def main(self, filename, topwords):
        txt = self.openfile(filename)
        txt = self.removegarbage(txt)
        words = txt.split(" ")
        for r in words:
            if not r in self.stop_words:
                appendFile = open('filteredtext.txt', 'a')
                appendFile.write(" " + r)
                appendFile.close()
        print(str(filename) + " ok!")
        file = open("tf_list.csv", "a")
        open('tf_list.csv', 'w').close()
        file.close()


if __name__ == "__main__":
    text_mining = TextMining()

    text_mining.main('document1.txt', 500)
    text_mining.main('document2.txt', 500)
    text_mining.main('document3.txt', 500)
    text_mining.main('document4.txt', 500)
    text_mining.main('document5.txt', 500)

    text_mining.tf_list_csv('filteredtext.txt', 500)
    text_mining.tfidf_list_csv('filteredtext.txt', 500)
    text_mining.world_cloud("tf_list.csv")
    text_mining.world_cloud("tfidf_list.csv")

# -*- coding: utf-8 -*-
"""
Created on Fri Dec  8 02:36:08 2017

@author: Ashish
"""

import pandas as pd
import numpy as np

dataset = pd.read_csv("diabetes.csv")

dataset.drop(dataset.columns[[0,3,6]], axis=1, inplace=True)

X= dataset.iloc[:,[0,1,2,3,4]].values
y= dataset.iloc[:,[5]].values


from sklearn.cross_validation import train_test_split
X_train,X_test,y_train,y_test = train_test_split(X, y, test_size = 0.20, random_state = 0)

from sklearn.linear_model import LogisticRegression
classifier = LogisticRegression(random_state=0)
classifier.fit(X_train,y_train)

test_set = pd.read_csv("in.csv")


y_pred= classifier.predict(test_set.values)
print(y_pred)

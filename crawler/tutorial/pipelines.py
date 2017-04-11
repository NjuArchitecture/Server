# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: http://doc.scrapy.org/en/latest/topics/item-pipeline.html
import json
import urllib
import urllib2


class TutorialPipeline(object):
    def __init__(self):
        self.result_list = []

    def process_item(self, item, spider):
        self.result_list.append(dict(item))
        return item

    def close_spider(self, spider):
        my_dict = {}
        my_dict['goodInfoList'] = self.result_list
        url = "http://localhost:8080/persist"
        data = json.dumps(my_dict)

        req = urllib2.Request(url, data)
        req.add_header('Content-Type', 'application/json;charset=UTF-8')
        req.add_header('Accept', 'application/json')
        response = urllib2.urlopen(req)
        print response.read()

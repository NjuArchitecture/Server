# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# http://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class TutorialItem(scrapy.Item):
    title = scrapy.Field()
    description = scrapy.Field()
    pic1 = scrapy.Field()
    pic2 = scrapy.Field()
    price = scrapy.Field()
    sourceName = scrapy.Field()
    sourceURL = scrapy.Field()
    pass

import scrapy
from tutorial.items import TutorialItem


class AmozonSpider(scrapy.Spider):
    name = "dmoz"
    start_urls = [
        "https://www.amazon.cn/s/ref=nb_sb_noss?__mk_zh_CN=%E4%BA%9A%E9%A9%AC%E9%80%8A%E7%BD%91%E7%AB%99&url=search-alias%3Daps&field-keywords=kindle"
    ]

    def parse(self, response):
        ul = response.xpath('//ul[@class="gl-warp clearfix"]')
        items = []
        for li in ul.xpath('.//li[@class="gl-item"]'):
            item = TutorialItem()
            price = li.xpath('.//div[@class="gl-i-wrap"]/div[@class="p-price"]/strong/i/text()').extract()
            title = li.xpath(
                './/div[@class="gl-i-wrap"]/div[@class="p-name p-name-type-2"]/a/em/text()').extract()
            description = li.xpath(
                './/div[@class="gl-i-wrap"]/div[@class="p-name p-name-type-2"]/a/@title').extract()
            img = li.xpath('.//div[@class="gl-i-wrap"]/div[@class="p-img"]/a/img/@src').extract()
            if img:
                pic1 = img
            else:
                pic1 = li.xpath('.//div[@class="gl-i-wrap"]/div[@class="p-img"]/a/img/@data-lazy-img').extract()
            pic2 = pic1
            item['sourceName'] = "jd"
            sourceURL = li.xpath(
                './/div[@class="gl-i-wrap"]/div[@class="p-name p-name-type-2"]/a/@href').extract()
            item['title'] = title[0].encode('utf-8')
            if price:
                item['price'] = price[0]
            else:
                item['price'] = 0
            item['description'] = description[0].encode('utf-8')
            item['pic1'] = pic1[0].encode('utf-8')
            item['pic2'] = pic2[0].encode('utf-8')
            item['sourceURL'] = sourceURL[0].encode('utf-8')
            items.append(item)
        return items

import scrapy

class DmozSpider(scrapy.Spider):
    name = "dmoz"
    start_urls = [
        "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&enc=utf-8&wq=%E6%89%8B%E6%9C%BA&pvid=e3b81c5824704815b3f25ddac26e17e1"
    ]

    def parse(self, response):
        for li in response.xpath('//ul[@class="gl-warp clearfix"]/li/div/div[@class="p-price"]/strong/i'):
            print (li.extract())

INSERT INTO SHORT_URL(HOST_DOMAIN, PATH, ORIGIN_URL) VALUES ('localhost:8080', 'abcd', 'http://www.naver.com');
INSERT INTO SHORT_URL(HOST_DOMAIN, PATH, ORIGIN_URL) VALUES ('localhost:8080', 'gWa2', 'http://www.daum.net');
INSERT INTO SHORT_URL(HOST_DOMAIN, PATH, ORIGIN_URL) VALUES ('localhost:8080', '3PwQ', 'http://www.nate.com');
INSERT INTO SHORT_URL(HOST_DOMAIN, PATH, ORIGIN_URL) VALUES ('localhost:8080', '5MbK', 'http://www.google.com');
INSERT INTO SHORT_URL(HOST_DOMAIN, PATH, ORIGIN_URL) VALUES ('localhost:8080', 'dMwN', 'http://www.skpla.net');

INSERT INTO ROUTE_LOG(PATH, USER_AGENT, REFERER, REMOTE_ADDRESS) VALUES ('abcd', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36', 'http://www.skpla.net', '0:0:0:0:0:0:0:1');
INSERT INTO ROUTE_LOG(PATH, USER_AGENT, REFERER, REMOTE_ADDRESS) VALUES ('abcd', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36', 'http://www.daum.net', '0:0:0:0:0:0:0:1');
INSERT INTO ROUTE_LOG(PATH, USER_AGENT, REFERER, REMOTE_ADDRESS) VALUES ('abcd', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36', 'http://www.naver.net', '0:0:0:0:0:0:0:1');
INSERT INTO ROUTE_LOG(PATH, USER_AGENT, REFERER, REMOTE_ADDRESS) VALUES ('abcd', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36', 'http://www.amazon.com', '0:0:0:0:0:0:0:1');
INSERT INTO ROUTE_LOG(PATH, USER_AGENT, REFERER, REMOTE_ADDRESS) VALUES ('abcd', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36', 'http://www.google.com', '0:0:0:0:0:0:0:1');
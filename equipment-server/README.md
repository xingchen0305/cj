## Equipment Server
- Build
`mvn clean package docker:build -Dmaven.test.skip=true`
- Run
`docker run --name equipment-server  -p 8080:8080 -d bupt626/equipment-server`



### Get Token 
curl localhost:9999/uaa/oauth/token -d "grant_type=password&scope=read&username=hexiuyu&password=123456" -u bupt-client:bupt626

### Get 命令行访问
curl -H "Authorization: bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsib2F1dGgyLXJlc291cmNlIl0sInVzZXJfbmFtZSI6ImhleGl1eXUiLCJzY29wZSI6WyJyZWFkIl0sImV4cCI6MTQ5OTEzNDUxMywiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiIsIlZJRVdfRkxJR0hUIl0sImp0aSI6IjE0ZWZiZDEzLTlhYzAtNDM4Ni1iYzY4LTNjMjNhYzQ2MWViMiIsImNsaWVudF9pZCI6ImJ1cHQtY2xpZW50In0.XahjDZICWMVd922oa1RGd9LCL16I0wyQw5RYvapu0qaSt2Qd1_sHpGykD6DBw23xU3BxZulNrLsjodRbkd0PgzJzH2KyUgf_lTcLcQQqs4GLzG18quAGMVOvrtDlOcSmtGKSeo5igNnbUshJGIOe5Ivb1xqyYdAbDgmlJWlEjuFYuZ4BGxlGBswRgAh4GN-6_vo3SIkX0EWxmugi9D1MGCe8Oz-S9cgU4EvIqjNvvZNyvtSKpbt0tWhyXolYznFWct5pKY62nPzgWTMipIdnJ0aoCfrvtx-0SwiSqWCeq0MOucEhNnhYVe5by_J7mZELPd4P2YPv1s7-sw46BYAFjw" 
"http://10.101.164.137:8755/baseWarehouse/page?page=2&size=5"
-- 코드를 입력하세요
# select * from rest_info

SELECT I.REST_ID,
     REST_NAME,
     FOOD_TYPE,
     FAVORITES,
     ADDRESS,
     ROUND(AVG(R.REVIEW_SCORE),2) AS SCORE
FROM REST_INFO I inner JOIN REST_REVIEW R
ON I.REST_ID = R.REST_ID
WHERE ADDRESS LIKE '서울%'
GROUP BY REST_ID
ORDER BY ROUND(AVG(R.REVIEW_SCORE)) DESC, I.FAVORITES DESC;
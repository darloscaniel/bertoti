CREATE DATABASE skateboardbd;

CREATE TABLE boards (
    id SERIAL PRIMARY KEY,
    brand VARCHAR(255) NOT NULL,
    size VARCHAR(50) NOT NULL,
	imgUrl VARCHAR(255)
);

INSERT INTO boards (brand, size, imgUrl) VALUES
('Element', '8.0', 'https://images.tcdn.com.br/img/img_prod/17375/shape_element_scipt_8_0_3077_1_20190223100308.jpg'),
('Santa Cruz', '8.25', 'https://th.bing.com/th/id/R.a175e92d28fa4c246f487b6bb791b8ef?rik=1S1LhMf7x3T8%2bA&pid=ImgRaw&r=0'),
('Powell Peralta', '7.75', 'https://th.bing.com/th/id/OIP.V6cG3k6ZzgaAHzKSsQf9eQHaHi?rs=1&pid=ImgDetMain');

select * from boards;
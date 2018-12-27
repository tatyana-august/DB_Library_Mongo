db.books.insert({id:'0', name:'Евгений Онегин', author:'0', genre:'0', language:'русский', status:'library'}) 
db.authors.insert({id:'0', name:'Пушкин А.С.', books:['0']}) 
db.genres.insert({id:'0', name:'Роман', books:['0']})

db.books.insert({id:'1', name:'Ворона и лисица', author:'1', genre:'1', language:'русский', status:'hand'}) 
db.authors.insert({id:'1', name:'Крылов И.А.', books:['1']}) 
db.genres.insert({id:'1', name:'Басня', books:['1']})

db.books.insert({id:'2', name:'Война и мир', author:'2', genre:'0', language:'русский', status:'library'}) 
db.authors.insert({id:'2', name:'Толстой Л.Н.', books:['2']}) 
db.genres.update({name:'Роман'}, {$push: {books: '2'}})

db.books.insert({id:'3', name:'Капитанская дочка', author:'0', genre:'0', language:'русский', status:'library'}) 
db.authors.update({name:'Пушкин А.С.'}, {$push: {books:'3'}}) 
db.genres.update({name:'Роман'}, {$push: {books: '3'}})

db.books.insert({id:'4', name:'Анна Каренина', author:'2', genre:'0', language:'русский', status:'library'}) 
db.authors.update({name:'Толстой Л.Н.'}, {$push: {books:'4'}}) 
db.genres.update({name:'Роман'}, {$push: {books: '4'}})

db.books.insert({id:'5', name:'Гамлет', author:'3', genre:'2', language:'русский', status:'library'}) 
db.authors.insert({id:'3', name:'Шекспир У.', books:['5']}) 
db.genres.insert({id:'2', name:'Трагедия', books:['5']})

db.books.insert({id:'6', name:'Гамлет', author:'3', genre:'2', language:'русский', status:'library'}) 
db.authors.update({name:'Шекспир У.'}, {$push: {books:'6'}}) 
db.genres.update({name:'Трагедия'}, {$push: {books: '6'}})

db.books.insert({id:'7', name:'Ромео и Джульетта', author:'3', genre:'2', language:'русский', status:'library'}) 
db.authors.update({name:'Шекспир У.'}, {$push: {books:'7'}}) 
db.genres.update({name:'Трагедия'}, {$push: {books: '7'}})

db.books.insert({id:'8', name:'1984', author:'4', genre:'0', language:'русский', status:'library'}) 
db.authors.insert({id:'4', name:'Оруэлл Д.', books:['8']}) 
db.genres.update({name:'Роман'}, {$push: {books: '8'}})

db.books.insert({id:'9', name:'Скотный двор', author:'4', genre:'0', language:'русский', status:'library'}) 
db.authors.update({name:'Оруэлл Д.'}, {$push: {books:'9'}})
db.genres.update({name:'Роман'}, {$push: {books: '9'}})

db.books.insert({id:'10', name:'Сказка о попе и о работнике его Балде', author:'0', genre:'3', language:'русский', status:'library'}) 
db.authors.update({name:'Пушкин А.С.'}, {$push: {books:'10'}})
db.genres.insert({id:'3', name:'Сказка', books:['10']})

db.books.insert({id:'11', name:'Сказка о рыбаке и рыбке', author:'0', genre:'3', language:'русский', status:'library'}) 
db.authors.update({name:'Пушкин А.С.'}, {$push: {books:'11'}})
db.genres.update({name:'Сказка'}, {$push: {books:'11'}})

db.books.insert({id:'12', name:'Сказка о золотом петушке', author:'0', genre:'3', language:'русский', status:'library'}) 
db.authors.update({name:'Пушкин А.С.'}, {$push: {books:'12'}})
db.genres.update({name:'Сказка'}, {$push: {books:'12'}})

db.books.insert({id:'13', name:'Над пропастью во ржи', author:'5', genre:'0', language:'русский', status:'hand'}) 
db.authors.insert({id:'5', name:'Сэлинджер Дж.', books:['13']}) 
db.genres.update({name:'Роман'}, {$push: {books:'13'}})

db.books.insert({id:'14', name:'Девять рассказов', author:'5', genre:'0', language:'русский', status:'hand'}) 
db.authors.update({name:'Сэлинджер Дж.'}, {$push: {books:'14'}}) 
db.genres.update({name:'Роман'}, {$push: {books:'14'}})

db.books.insert({id:'15', name:'Мать', author:'6', genre:'0', language:'русский', status:'hand'}) 
db.authors.insert({id:'6', name:'Горький М.', books:['15']}) 
db.genres.update({name:'Роман'}, {$push: {books:'15'}})

db.books.insert({id:'16', name:'Челкаш', author:'6', genre:'0', language:'русский', status:'hand'}) 
db.authors.update({name:'Горький М.'}, {$push: {books:'16'}}) 
db.genres.update({name:'Роман'}, {$push: {books:'16'}})

db.books.insert({id:'17', name:'Детство', author:'6', genre:'0', language:'русский', status:'hand'}) 
db.authors.update({name:'Горький М.'}, {$push: {books:'17'}}) 
db.genres.update({name:'Роман'}, {$push: {books:'17'}})

db.books.insert({id:'18', name:'Старуха Изергиль', author:'6', genre:'0', language:'русский', status:'hand'}) 
db.authors.update({name:'Горький М.'}, {$push: {books:'18'}}) 
db.genres.update({name:'Роман'}, {$push: {books:'18'}})

db.books.insert({id:'19', name:'Мои университеты', author:'6', genre:'0', language:'русский', status:'hand'}) 
db.authors.update({name:'Горький М.'}, {$push: {books:'19'}}) 
db.genres.update({name:'Роман'}, {$push: {books:'19'}})
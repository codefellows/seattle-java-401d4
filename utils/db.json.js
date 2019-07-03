let account = {
  id: 'a-b-c-d',
  name: 'Johnny',
  paymentInfo: 'hashed',
  searchHistory: [],
  viewingHistory: [
    {
      item: 'thing',
      duration: 10000,
      readComments: true,
    },
  ],
  lists: [
    {
      name: 'Wish List',
      items: [],
    },
    {
      name: 'Cokos Christmas List',
      items: [ {}, {} ],
    },
  ],
  orders: [
    {
      id: '1-1-1-1',
      status: 'shipped',
      shippingAddress: {
        street: '',
        'zip': '',
      },
      items: [
        {
          name: 'razor',
          manufacturer: 'pitbull',
          description: 'Head Saving Device',
          productId: '2-2-2-2',
          price: 99.97,
          quantity: 1,
        }, {'name': 'computer'}, {},
      ],
    },
    {id: '3-3-3-3'},
  ],
};

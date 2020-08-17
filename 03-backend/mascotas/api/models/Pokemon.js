/**
 * Pokemon.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    nombre:{
      type: 'string'
    },
    usuario: { // Many to One (nombre FK) - mismo nombre q la relacion
      model: 'usuario',
      required: true // (Es opcional 1 muchos 0 muchos)
    }
  },
};


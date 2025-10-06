# Métodos HTTP

Este documento descreve os principais métodos HTTP utilizados em aplicações web, APIs RESTful e comunicação cliente-servidor.

---

## Métodos HTTP Comuns

| Método | Descrição | Uso Típico | Idempotência | Exemplo de Uso |
|--------|-----------|------------|--------------|----------------|
| **GET** | Solicita a representação de um recurso. Não deve alterar o estado do servidor. | Recuperar dados de um recurso. | ✅ Idempotente | `GET /usuarios` → retorna lista de usuários |
| **POST** | Envia dados para criar um novo recurso ou processar dados no servidor. | Criar novos registros. | ❌ Não idempotente | `POST /usuarios` com corpo JSON `{ "nome": "Carlos" }` |
| **PUT** | Atualiza completamente um recurso existente ou cria se não existir. | Substituir totalmente o recurso. | ✅ Idempotente | `PUT /usuarios/1` com corpo JSON `{ "nome": "Carlos Novo" }` |
| **PATCH** | Atualiza parcialmente um recurso existente. | Modificações parciais. | ❌ Não necessariamente idempotente | `PATCH /usuarios/1` com JSON `{ "nome": "Carlos Atualizado" }` |
| **DELETE** | Remove um recurso do servidor. | Apagar registros. | ✅ Idempotente | `DELETE /usuarios/1` |
| **OPTIONS** | Retorna os métodos HTTP suportados por um recurso. | Descobrir funcionalidades suportadas. | ✅ Idempotente | `OPTIONS /usuarios` |
| **HEAD** | Retorna apenas os headers de um recurso, sem corpo. | Verificar metadados, como tamanho ou data. | ✅ Idempotente | `HEAD /usuarios/1` |

---

## ⚡ Observações Importantes

1. **Idempotência:**  
   - Um método é idempotente se executar múltiplas vezes o mesmo pedido tem o mesmo efeito que executá-lo uma vez.  
   - Ex.: `GET`, `PUT`, `DELETE` são idempotentes; `POST` normalmente não é.

2. **Segurança:**  
   - Métodos seguros não alteram o estado do servidor: `GET`, `HEAD`, `OPTIONS`.  
   - Métodos inseguros podem alterar dados: `POST`, `PUT`, `PATCH`, `DELETE`.

3. **Boas práticas em APIs RESTful:**  
   - Use **GET** para leitura.  
   - Use **POST** para criar recursos.  
   - Use **PUT** para substituir recursos.  
   - Use **PATCH** para atualizar parcialmente.  
   - Use **DELETE** para remover recursos.  
   - Sempre retornar códigos HTTP adequados (`200 OK`, `201 Created`, `204 No Content`, `404 Not Found`, etc.).

---

## Exemplos de Uso com `curl`

```bash
# GET
curl -X GET https://api.exemplo.com/usuarios

# POST
curl -X POST https://api.exemplo.com/usuarios \
     -H "Content-Type: application/json" \
     -d '{"nome":"Carlos"}'

# PUT
curl -X PUT https://api.exemplo.com/usuarios/1 \
     -H "Content-Type: application/json" \
     -d '{"nome":"Carlos Atualizado"}'

# PATCH
curl -X PATCH https://api.exemplo.com/usuarios/1 \
     -H "Content-Type: application/json" \
     -d '{"nome":"Carlos Parcial"}'

# DELETE
curl -X DELETE https://api.exemplo.com/usuarios/1
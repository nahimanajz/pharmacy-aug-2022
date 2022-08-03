export function Record({data, title}){
    const {A:yearOne,B:yearTwo, C:yearThree, } = data[0]
    data.shift()
    return (
        <div className="info">
            <h3>{title}</h3>
            <table> 
                <thead>
                    <tr>
                        <th>{yearOne}</th>
                        <th>{yearTwo}</th>
                        <th>{yearThree}</th>
                    </tr>
                </thead>             
                <tbody>
                    {data?.map( ({A ,B, C}) =>(
                            <tr key={A}>
                               <td >{A}</td> 
                                <td>{B}</td> 
                                <td>{C}</td> 
                            </tr>
                        ))}
                </tbody>
            </table>
            </div>
    )
}
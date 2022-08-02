export function Record({data, title}){
    return (
        <div className="info">
            <h2>{title}</h2>
            <table>                
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